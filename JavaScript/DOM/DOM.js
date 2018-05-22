
var users = [{name: "Michael", age:37}, {name: "John", age:30}, {name: "David", age:27}];
//How would you print/log John's age?
console.log(users[1].age);

//ow would you print/log the name of the first object?
console.log(users[0].name,users[0].age);


//How would you print/log the name and age of each user using a for loop? 
for(var i=0;i<users.length;i++)
{
	console.log(users[i].name,users[i].age);
}

Michael 37
John 30
David 30 


