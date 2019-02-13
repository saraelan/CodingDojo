# Create a site that when a user loads it creates a random number between 1-100 and stores the number in session. Allow the user to guess at the number and tell them when they are too high or too low. If they guess the correct number tell them and offer to play again.


from flask import Flask, render_template, request, redirect, session
import random
app = Flask(__name__)
app.secret_key = 'ThisIsSecret'



@app.route('/')
def index():
	session['numbers'] = random.randrange(1,101)
	return redirect('/show')

@app.route('/show')
def show():
    return render_template('index.html')


@app.route('/result',methods=['POST'] )
def result():
	num=request.form['numbers']
	text='no'
	if int(num)>int(session['numbers']):
		text='Too High'
	elif int(num)<int(session['numbers']):
		text='Too Low'
	elif int(num)==int(session['numbers']):
		text=num+'was the no!'
		text='yes'

	return render_template('result.html',text=text,value=value)






app.run(debug=True)


