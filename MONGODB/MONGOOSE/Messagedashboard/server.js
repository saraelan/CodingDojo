
var express     = require("express");
var path        = require("path");
var bodyParser  = require("body-parser");
var session     = require("express-session");
var app         = express();

var mongoose    = require('mongoose');
mongoose.connect('mongodb://localhost/Message_mongoose');
var Schema = mongoose.Schema;

const PostSchema=new mongoose.Schema({
name: {type: String, required: true, minlength: 3},
text: {type: String, required: true, minlength: 3},
comments: [{type: Schema.Types.ObjectId, ref: 'Comment'}]
    }, {timestamps: true});

const CommentSchema=new mongoose.Schema({
    _post: {type: Schema.Types.ObjectId, ref: 'Post'},
    name: {type: String, required: true, minlength: 3},
    text: {type: String, required: true, minlength: 3}
    }, {timestamps: true});

	mongoose.model('Post', PostSchema);     
    mongoose.model('Comment', CommentSchema);     
    var Post = mongoose.model('Post');       
    var Comment = mongoose.model('Comment'); 

app.use(session({ secret: "kittykatlicklick" }));
app.use(bodyParser.urlencoded({ extended:true }));
app.use(express.static(path.join(__dirname, "./static")));
app.set('views', path.join(__dirname, "./views"));
app.set('view engine', 'ejs');

app.get('/', function(req, res) {
    Post.find({})
        .populate('comments')
        .exec(function (err, posts) {
        	if (err) {
            console.log('unable to reach database');
        } else {
            res.render("index", {posts : posts})
        }
    })
})

app.post('/addPost', function(req, res) {
    var post = new Post(req.body);
    console.log('post info:', post);
    post.save(function(err){
        if(err){
            console.log('Something went wrong');
            res.redirect('/');
        } else {
            console.log('Added a Post');
            res.redirect('/');
        }
    })
})


app.post('/addComment/:id', function(req, res) {
    Post.findOne({_id: req.params.id}, function(err, post){
        var comment = new Comment(req.body);
        comment._post = post._id;                               // Creates one comment with the parent post id
        post.comments.push(comment);                            // Pushes comment into array
        comment.save(function(err){                             // Saves comment into array
            post.save(function(err){                            // saves post
                if(err){
                    console.log('Add comment again');
                } else {
                    console.log('Comment added');
                    res.redirect('/')
                }
            })
        })
    })
})

app.listen(8000, function() {
    console.log("listening on port 8000");
})