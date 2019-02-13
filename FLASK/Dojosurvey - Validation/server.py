# Build a flask application that accepts a form submission and presents the submitted data on a results page.

# # http://localhost:5000 - have this display a nice looking HTML form.  The form should be submitted to '/result'
# http://localhost:5000/result - have this display a html with the information that was submitted by POST
# http://localhost:5000/danger - have this redirect back to "/".  Before redirecting back print in the terminal/console a message: "a user tried to visit /danger.  we have redirected the user to /".
# Take the Dojo Survey assignment that you completed previously and add validations! The Name and Comment fields should be validated so that they are not blank. Also, validate that the comment field is no longer than 120 characters.




from flask import Flask, render_template, request, redirect,flash

app = Flask(__name__)
app.secret_key = "ThisIsSecret!"


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

  if len(request.form['name']) < 1:
    flash("Name cannot be empty!") # just pass a string to the flash function
  else:
    flash("Success! Your name field is {}.".format(request.form['name']))
  if len(request.form['comment']) < 1:
    flash("Comment field cannot be empty!")
  elif len(request.form['comment']) > 120:
    flash("Comment field cannot be longer than 120 characters.")
  else:
    flash(f"Success! Your comment field is less than 120 characters.{request.form['comment']}.")





  return render_template('result.html', name=request.form['name'], location=request.form['location'],   language=request.form['language'], comment=request.form['comment'])
  return redirect('index.html')

# @app.route('/result',methods=['POST'])
# def result():
# 	return redirect('/')

app.run(debug=True)