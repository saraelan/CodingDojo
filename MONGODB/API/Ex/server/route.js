const getAllTasks=require("./controller.js")
const bp=requie('body-parser');

module.exports=function(app)
app.get("/tasks",getAllTasks)
app.post("/tasks",createTasks)