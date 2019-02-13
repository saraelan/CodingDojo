#1.Write a program that generates an HTML page that looks like a checkerboard. should display 8 by 8 checkerboard

from flask import Flask, render_template  # Import Flask to allow us to create our app, and import
                                          # render_template to allow us to render index.html.
app = Flask(__name__)  

@app.route('/checker')
def boxs():
	print("hello")
	return render_template("index.html")


# should display x by y checkerboard.  For example, http://localhost:5000/10/10 should display 10 by 10 checkerboard. 
# @app.route('/checker/<times>')
# def box(times):
# 	print("hello")
# 	return render_template("index.html",times=int(times))

@app.route('/checker/<x>/<y>')
def box1(x,y):
	print("hello")
	return render_template("index.html",x=int(x),y=int(y))



if __name__=="__main__":
	app.run(debug=True) #Run the app in debug mode.

