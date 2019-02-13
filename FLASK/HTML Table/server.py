
# Create the following tuple of dictionaries and have it available for your route. 



from flask import Flask, render_template  # Import Flask to allow us to create our app, and import
                                          # render_template to allow us to render index.html.
app = Flask(__name__)  



@app.route('/h')
def boxs():
	print("hello")
	users =(
   {'first_name' : 'Michael', 'last_name' : 'Choi'},
   {'first_name' : 'John', 'last_name' : 'Supsupin'},
   {'first_name' : 'Mark', 'last_name' : 'Guillen'},
   {'first_name' : 'KB', 'last_name' : 'Tonel'}
);
	return render_template("index.html",users=users)


if __name__=="__main__":
	app.run(debug=True) #Run the app in debug mode.
