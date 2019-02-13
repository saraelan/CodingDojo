#Level 1 Playground
#When a user visits http://localhost:5000/play, have it render three beautiful looking blue boxes.  Please use a template to render this.


from flask import Flask, render_template  # Import Flask to allow us to create our app, and import
                                          # render_template to allow us to render index.html.
app = Flask(__name__)  


# 1.When a user visits http://localhost:5000/play, have it render three beautiful looking blue boxes. 
# 2.When a user visits localhost:5000/play/(x), have it display the beautiful looking blue boxes x times. 
@app.route('/play/<times>')
def box(times):
	print("hello")
	return render_template("index.html",times=int(times))


# 3.When a user visits localhost:5000/play/(x)/(color), have it display beautiful looking boxes x times, but this time where the boxes appear in (color). 
@app.route('/plays/<times>/<fitcolor>')
def boxs(times,fitcolor):
	print("hello")
	return render_template("index.html",times=int(times),fitcolor=fitcolor)




if __name__=="__main__":
     app.run(debug=True)