// Get 1 to 255 - Write a function that returns an array with all the numbers from 1 to 255.
function numbers()
{	console.log("Array to 1 to 255");
	for(var i=1;i<=255;i++)
	{
		console.log(i);
	}
}
numbers();


//Get even 1000 - Write a function that would get the sum of all the even numbers from 1 to 1000.  You may use a modulus operator for this exercise.
function evens()

{	var sum=0;
	for(var i=1;i<=1000;i++)
	{
		if(i%2===0)
		{
			sum=sum+1;
		}
	}

	console.log("Sum of even numbers",sum);
}
evens();


//Sum odd 5000 - Write a function that returns the sum of all the odd numbers from 1 to 5000. (e.g. 1+3+5+...+4997+4999).
function odds()

{	var sum=0;
	for(var i=1;i<=5000;i++)
	{
		if(i%2!==0)
		{
			sum=sum+1;
		}
	}

	console.log("Sum of odds numbers",sum);
}
odds();

//Iterate an array - Write a function that returns the sum of all the values within an array. (e.g. [1,2,5] returns 8. [-5,2,5,12] returns 14).
function sumarr(arr)
{
var sum=0;
for(var i=0;i<arr.length;i++)	
{
	sum =sum+arr[i];
}
console.log("Sum of values in array",sum);
}
sumarr([1,2,5]);
sumarr([-5,2,5,12]);

//Find max - Given an array with multiple values, write a function that returns the maximum number in the array. (e.g. for [-3,3,5,7] max is 7)
function maximumarr(arr)
{
	var max=arr[0];
	for(var i=0;i<arr.length;i++)
	{
		if(arr[i]>max)
		{
		max=arr[i];
	}
	}
console.log("Maximum of array:",max);

}
maximumarr([-3,3,5,7]);


//Find average - Given an array with multiple values, write a function that returns the average of the values in the array. (e.g. for [1,3,5,7,20] average is 7.2)
function avgarray(arr)
{
	var avg=0;
	var sum=0;
	for(var i=0;i<arr.length;i++)	
{
	sum =sum+arr[i];
}
avg=sum/arr.length;
console.log("Averageg of the array:",avg);
}
avgarray([1,3,5,7,20]);

//Array odd - Write a function that would return an array of all the odd numbers between 1 to 50. (ex. [1,3,5, .... , 47,49]). Hint: Use 'push' method.
function oddarr(arr)
{ var arr=[];
	for(var i=1;i<=50;i++)
	{
			if(i%2!==0)
		{
			arr.push(i);	
		}
	}
console.log("Odd numbers",arr);
}
oddarr();

// /Greater than Y - Given value of Y, write a function that takes an array and returns the number of values that are greater than Y. For example if arr = [1, 3, 5, 7] and Y = 3, your function will return 2. (There are two values in the array greater than 3, which are 5, 7).

function greatervalue(arr,y)
{
	for(var i=0;i<arr.length;i++)	
	{
		if(arr[i]>y)

		{
			console.log("Value greater than",y, arr[i]);
		}
	}

}
greatervalue([1, 3, 5, 7],3);

//Squares - Given an array with multiple values, write a function that replaces each value in the array with the product of the original value squared by itself. (e.g. [1,5,10,-2] will become [1,25,100,4])
function squaresarr(arr)
{
	for(var i=0;i<arr.length;i++)
	{
		arr[i]=arr[i]*arr[i];

	}

	console.log("Squaing values",arr);
}
squaresarr( [1,5,10,-2]);

//Negatives - Given an array with multiple values, write a function that replaces any negative numbers within the array with the value of 0. When the program is done the array should contain no negative values. (e.g. [1,5,10,-2] will become [1,5,10,0])
function negativevalues(arr)
{
	for(var i=0;i<arr.length;i++)
	{
		if (arr[i]<0)
		{
			arr[i]=0;
		}
	}

		console.log ("Removing negatives",arr);
}
negativevalues( [1,5,10,-2]);

//Max/Min/Avg - Given an array with multiple values, write a function that returns a new array that only contains the maximum, minimum, and average values of the original array. (e.g. [1,5,10,-2] will return [10,-2,3.5])
function operationsarr(arr)
{
	var max=arr[0];
	var min=arr[0];
	var sum=0;
	var avg=0;
	for(var i=0;i<arr.length;i++)
	{
		if(arr[i]>max)
		{
		max=arr[i];
		}
		else if(arr[i]<min)
		{
			min=arr[i];
		}
		sum=sum+arr[i];
		avg=sum/arr.length;
		
	}

	console.log("Max,min ,and avg ",[max,min,avg]);

}

operationsarr([1,5,10,-2]);


//Swap Values - Write a function that will swap the first and last values of any given array. The default minimum length of the array is 2. (e.g. [1,5,10,-2] will become [-2,5,10,1]).
function swap(arr)
{	

	var temp;
	var c =arr.length;
	for (var i = 0; i < arr.length; i++) 
	{
			temp = arr[c-1-i];
	        arr[c-1-i]=arr[i];
	        arr[i]=temp;
	    	
		
	}
	
	console.log(arr);
}
swap([1,5,10,-2]);

//Number to String - Write a function that takes an array of numbers and replaces any negative values within the array with the string 'Dojo'. For example if array = [-1,-3,2], your function will return ['Dojo','Dojo',2].
function numbertostring(arr)
{
	for(var i=0;i<arr.length;i++)
	{
		if(arr[i]<0)
		{
			arr[i]="Dojo";
		}
	}
	console.log("new arr",arr);
	
}
numbertostring([-1,-3,2]);