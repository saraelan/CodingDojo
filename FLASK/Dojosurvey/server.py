# Build a flask application that accepts a form submission and presents the submitted data on a results page.

# # http://localhost:5000 - have this display a nice looking HTML form.  The form should be submitted to '/result'
# http://localhost:5000/result - have this display a html with the information that was submitted by POST
# http://localhost:5000/danger - have this redirect back to "/".  Before redirecting back print in the terminal/console a message: "a user tried to visit /danger.  we have redirected the user to /".




from flask import Flask, render_template, request, redirect

app = Flask(__name__)

@app.route('/')
def index():
  return render_template('index.html')

@app.route('/result',methods=['POST'])
def process():
  print ("Got Post Info ")
  name = request.form['name']
  location = request.form['location']
  language = request.form['language']
  comment = request.form['comment']
  print ("name")
  print ("location")
  print ("language")
  print ("comment")
  return render_template('results.html', name=request.form['name'], location=request.form['location'],   language=request.form['language'], comment=request.form['comment'])
  # return redirect('/')

@app.route('/result',methods=['GET'])
def result():
	return redirect('/')

app.run(debug=True)