var mongose =require('mongoose');


mongoose.connect('mongodb://localhost/Task_mongoose');
const TaskSchema =new mongoose.Schema({
	title:
	{
		type:String,
		minlength:[2,"Small"]
	},
	description:
	{
		type:String,
		minlength:[2,"Smalley"]
	},
	completed:
	{
		type:Boolean,
		default:false

	}
},{timestamps:true}

const Tasks=mongoose.model
