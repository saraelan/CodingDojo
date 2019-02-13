from flask import Flask, render_template, request, redirect, session
import random
app = Flask(__name__)
app.secret_key = 'ThisIsSecret'


# print in the terminal what's stored in session as well have have it render a template.
@app.route('/')
def index():
	if 'count' not in session:
		session['count']=0
	else:
		session['count']+=1

	return render_template("index.html",count=session['count'])


# clear session (e.g. session.clear()).  Once the session is cleared, redirect to the root.
@app.route('/destroy',methods=['POST'])
def destroy():
	session.clear()
	return redirect('/')


# Add a +2 button underneath the counter that reloads the page and increments counter by 2. Add another route to handle this functionality.

@app.route('/add2',methods=['POST'])
def add2():
	session['count']+=1
	return redirect('/')



# Add a reset button that resets the counter back to 1. Add another route to handle this functionality.
@app.route('/decrements',methods=['POST'])
def decrements():
	session['count']-=1	
	return redirect('/')


app.run(debug=True)


