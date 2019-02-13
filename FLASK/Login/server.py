from flask import Flask, request, redirect, render_template, session, flash

from mysqlconnection import connectToMySQL
import re



# Check for Valid Email format
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

# NAME_REGEX Check letters only, at least 2 characters /^[a-zA-Z]{2,}$/
NAME_REGEX = re.compile(r'^[a-zA-Z]{2,}$')

# PASSWORD_REGEX at least 8 characters /^.{8,}$/
PASSWORD_REGEX = re.compile(r'^.{8,}$')



app = Flask(__name__)
app.secret_key = 'KeepItSecretKeepItSafe'
mysql = connectToMySQL('email_validation')



@app.route('/')
def index():
	 return render_template("index.html")


@app.route('/registration', methods=['POST'])
def validate():
	session.clear()
	errors=False
	print("Give the details")
	session['first_name'] = request.form['first_name']
	session['last_name'] = request.form['last_name']
	session['email'] = request.form['email']
	session['password'] = request.form['password']
	session['confirm_pwd'] = request.form['confirm_pwd']
	print ("first_name, last_name, email, password, confirm_pwd")

	

	
	if len(request.form['first_name']) < 1:
		flash("Name cannot be empty!",'registrationerror')
	elif not NAME_REGEX.match(request.form['first_name']):
		flash("Invalid characters or not at least 2 characters in first name.",'registrationerror')
		errors = True
	if len(request.form['last_name']) < 1:
		flash("Name cannot be empty!",'registrationerror')
	elif not NAME_REGEX.match(request.form['last_name']):
		flash("Invalid characters or not at least 2 characters in last name.",'registrationerror')
		errors = True
	if len(request.form['email']) < 1:
		flash("You must enter an email address.",'registrationerror')
		errors = True
	elif not EMAIL_REGEX.match(request.form['email']):
		flash("Invalid email address.",'registrationerror')
		errors = True
	if len(request.form['password']) < 1:
		flash("You must enter a password.",'registrationerror')
		errors = True
	elif not PASSWORD_REGEX.match(request.form['password']):
		flash("Passwords must be 8 characters or more.",'registrationerror')
		errors = True
	if len(request.form['confirm_pwd']) < 1:
		flash("You must confirm your password.",'registrationerror')
		errors = True
	elif request.form['confirm_pwd'] != request.form['password']:
		flash("Confirm Password must match Password.",'registrationerror')
		errors = True
	if errors:
		return redirect('/') 
	else:
		
		query = "INSERT INTO userss(first_name, last_name,email,password,created_at,updated_at) VALUES (%(first_name)s, %(last_name)s, %(email)s,%(password)s, NOW(), NOW());"
		data={'first_name':request.form['first_name'],'last_name':request.form['last_name'],'email':request.form['email'],'password':request.form['password']}	

		
		result=mysql.query_db(query,data)
		print(result)
		
		return redirect('/success/registered')
     
   

@app.route('/validate_login', methods=['POST'])
def validate_login():
    errors = False
    # email = request.form['email']
    # password = request.form['password']

    if len(request.form['email']) < 1:
        flash("You must enter an email address.",'loginerror')
        errors = True   
    if len(request.form['password']) < 1:
        flash("You must enter a password.",'loginerror')
        errors = True
    else:
    	
    	query = "SELECT password, first_name, last_name FROM userss WHERE email = '" + request.form['email'] + "'"
    	data={'email':request.form['email'],'password':request.form['password']}


    	result=mysql.query_db(query,data)
    	print(result)


    if len(request.form['email']) < 1:
    	flash("Email is not in registration database.",'loginerror')
    	errors = True
    	print ("Email not found login error")
    elif request.form['password']!=request.form['password']:
    	flash("Password is not correct.",'loginerror')
    	errors = True  
    	
    print (errors)
    if errors:
        return redirect('/')        
    else:
        
        return redirect ('/success/loggedin') 

@app.route('/success/<action>')
def success(action): 
    flash("You are "+action+"!",'success')
    return render_template('success.html') 

@app.route('/back', methods=['POST'])
def back():
    session.clear()
    return redirect('/')



app.run(debug = True)


