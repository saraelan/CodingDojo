//Given an array and a value Y, count and print the number of array values greater than Y.
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

//Given an array, print the max, min and average values for that array.
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


//Given an array of numbers, create a function that returns a new array where negative values were replaced with the string ‘Dojo’.   For example, replaceNegatives( [1,2,-3,-5,5]) should return [1,2, "Dojo", "Dojo", 5].
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

