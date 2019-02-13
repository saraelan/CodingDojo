# Assignment: Registration Form
#
# Create a simple registration page with the following fields:
#
#     email
#     first_name
#     last_name
#     password
#     confirm_password
#
# Here are the validations you must include:
#
#     All fields are required and must not be blank
#     First and Last Name cannot contain any numbers
#     Password should be more than 8 characters
#     Email should be a valid email
#     Password and Password Confirmation should match
#     When the form is submitted, make sure the user submits appropriate information.
#         If the user did not submit appropriate information, return the error(s) above
#         the form that asks the user to correct the information. 
#
# Message Flashing with Categories
# For this, you will need to use flash messages at the very least. You may have to take this
# one step further and add categories to the flash messages. You can learn that from the flask doc:
# flash messages with categories
#
# If the form with all the information is submitted properly, simply have it say a message
#  "Thanks for submitting your information."
#
#
# Ninja Version:
# Add the validation that requires a password to have at least 1 uppercase letter and 1 numeric value.
#
#
# Hacker Version:
# Add a birth-date field that must be validated as a valid date and must be from the past.
from flask import Flask, render_template, request, redirect,flash

app = Flask(__name__)
app.secret_key = "ThisIsSecret!"
import re
import time
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
NAME_REGEX = re.compile(r'^[^0-9]+$')
PASSWORD_REGEX = re.compile(r'^([^0-9]*|[^A-Z]*)$')
BIRTHDAY_REGEX = re.compile(r'^[01][0-9]/[0-3][0-9]/[1-2][09][0-9][0-9]$')


@app.route('/')
def index():
    return render_template('index.html')

@app.route('/validate',methods=['POST'])
def validate():
	fname=request.form['fname']
    lname=request.form['lname']
    email=request.form['email']
    birthday=request.form['birthday']
    password=request.form['password']
    cpassword=request.form['cpassword']
    print("fname")
    print("lname")
    print("email")
    print("password")
    print("cpassword")
    
     if len(fname) < 1:
        flash(f"You must enter your first name.{request.form['fname']}")
    elif not NAME_REGEX.match(request.form['fname']):
        flash("Invalid characters in first name.")
    
    if len(lname) < 1:
        flash("You must enter your last name.",'error')
    elif not NAME_REGEX.match(request.form['lname']):
        flash("Invalid characters in last name.",'error')
    
    if len(birthday) < 1:
        flash("You must enter a birth date.",'error')
    elif not DATE_REGEX.match(request.form['birth_date']):
        flash("Invalid date for birthdate -- must be yyyy-mm-dd.",'error')
    elif birth_date >= today:
        flash("Your birth date must be in the past.",'error')
    
    if len(email) < 1:
        flash("You must enter an email address.",'error')
    elif not EMAIL_REGEX.match(request.form['email']):
        flash("Invalid email address.",'error')
    
    if len(password) < 1:
        flash("You must enter a password.",'error')
    elif len(password) < 9:
        flash("Passwords must be 9 characters or more.",'error')
    elif PASSWORD_REGEX.match(request.form['password']):
        flash("Passwords must contain at least uppercase letter and at least one number.",'error')
    
    if len(cpassword) < 1:
        flash("You must confirm your password.",'error')
    elif confirm_pwd != password:
        flash("Confirm Password must match Password.",'error')
    
    return render_template('result.html', first_name=first_name, last_name=last_name, birth_date=birth_date,email=email, password=password, confirm_pwd=confirm_pwd) 