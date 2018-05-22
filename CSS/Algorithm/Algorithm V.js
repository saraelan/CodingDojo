//Return the given array, after setting any negative values to zero.  For example resetNegatives( [1,2,-1, -3]) should return [1,2,0,0].
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
negativevalues( 1,2,-1, -3);

//Given an array, move all values forward by one index, dropping the first and leaving a ‘0’ value at the end.  For example moveForward( [1,2,3]) should return [2,3,0].
function shiftarr(arr) 
{
	var temp = arr[0];
	for (var i = 0; i < arr.length - 1; i++) 
	{
		arr[i] = arr[i+1];
	}
	arr[arr.length - 1] = temp;
	console.log("Shifting values",arr);
}
shiftarr([1,2,3]);




//Given an array, return an array with values in a reversed order.  For example, returnReversed([1,2,3]) should return [3,2,1].
function reverseArray(arr) 
{
var c=arr.length;
for(var i = 0; i < arr.length/2; i++) 
{
var temp = arr[i];
arr[i] = arr[c-i-1];
arr[c-i-1] = temp;
}
console.log("After reversing",arr);
return arr;
}
reverseArray([1,2,3]);


//Create a function that changes a given array to list each original element twice, retaining original order.  Have the function return the new array.  For example repeatTwice( [4,”Ulysses”, 42, false] ) should return [4,4, “Ulysses”, “Ulysses”, 42, 42, false, false].
function double(arr)
{
  var l=arr.length;
  for(var i=0;i<l;i++)
  {
    arr.push(0);
  }

  for(var i=l-1;i>=0;i--)
  {
    arr[(i*2)+1]=arr[i];
    arr[i*2]=arr[i];
     
  }

  console.log("After doubling",arr);
 
}
double([4, "Ulysses", 42, false]);

