// /Biggie Size-Given an array, write a function that changes all positive numbers in the array to "big".  Example: makeItBig([-1,3,5,-5]) returns that same array, changed to [-1, "big", "big", -5].
function makeItBig(arr)
{
	for(i=0;i<arr.length;i++)
	{
	if(arr[i]>0)
	{
	arr[i]="big"
	}
	}
	console.log("Positive numbers to big",arr);
	return arr;
}
makeItBig([-1,3,5,-5]);


//Print Low , return High -Create a function that takes array of numbers.  The function should print the lowest value in the array, and return the highest value in the array.
function lowHigh(arr)
{
var low =arr[0];
var high=arr[0];
	for(var i=0;i<arr.length;i++)
{
	if(arr[i]<low)
	{
		low=arr[i];
		
	}
	else if(arr[i]>high)
	{
		high=arr[i];
		
	}

}
console.log("Lowest umber in array",low);
return high;
}
lowHigh([2,1,5,6]);


//Print one return another - Build a function that takes array of numbers.  The function should print second-to-last value in the array, and return first odd value in the array.

function printreturn(arr) 

{	
   var odd=arr[0];
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] % 2 !== 0) 
        {
         	 odd=arr[i]; 
         	  
        }
    }
console.log("Second to last value", arr[arr.length - 2]);
return odd;

}

printreturn([2, 1, 4, 5, 6]);


// Double vision Given array, create a function to return a new array where each value in the original has been doubled.  Calling double([1,2,3]) should return [2,4,6] without changing original.
function doubleVision(arr)
{
	var newarr=[];
	for (var i = 0; i < arr.length; i++)
	{
            newarr.push(arr[i] * 2);
    }
    console.log("After doubling",newarr);
}

doubleVision([1,2,3]);

//Count Positives - Given array of numbers, create function to replace last value with number of positive values.  Example, countPositives([-1,1,1,1]) changes array to [-1,1,1,3] and returns it.
function countPositive (arr)
{	var c =0;
	for(var i=0;i<arr.length;i++)
	{
		if(arr[i]>0)
		{
			c++;
		}
	}

	arr[arr.length-1]=c;
	console.log("Replace the last value in aray",arr);
	return arr;
	

}
countPositive([-1,1,1,1])

//Irement the Seconds - Given an array of numbers arr, add 1 to every secondIelement, specifically those whose index is odd (arr[1], [3], [5], etc).  Afterward. console.log each array value and return arr.
function increment(arr) 
{
    for (var i = 0; i < arr.length; i++)
     {
       	 if(i%2!==0)
         arr[i] = arr[i] + 1;         
        
    }

     console.log("Adding 1 to every element",arr);
    return arr;
}


increment([1, 2, 3, 4]);

//Previous Lengths - You are passed an array containing strings.  Working within that same array, replace each string with a number - the length of the string at previous array index - and return the array
function previousLength(arr)
{

	for(var i=arr.length-1;i<=0;i--)
	{
		
	arr[i]=arr[i-1].length;
	}
	return arr;
}
console.log(previousLength(['size','double','count']));

//Add Seven to Most - Build function that accepts array. Return a new array with all values except first, adding 7 to each. Do not alter the original array.
function addSeven(arr)
{
	var newarr=[];
	for(var i=1;i<arr.length;i++)
	{
		newarr.push(arr[i]+7);
	}
	console.log("Pushing 7 to each",newarr);
	return arr;
}
addSeven([1,2,3,4,5,6,7])


//Given an array, write a function that reverses values, in-place.  Example: reverse([3,1,6,4,2]) return same array, containing [2,4,6,1,3].  Do this without creating an empty temporary array.  (Hint: you'll need to swap values).

function reversearry(arr) 
{
    for (var i = 0; i < arr.length/2; i++) 
    {
        var temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
    }
    console.log("reverse",arr);
}

 reversearry([3, 1, 6,4,2]);

//Outlook: Negative - Given an array, create and return a new one containing all the values of the provided array, made negative (not simply multiplied by -1). Given [1,-3,5], return [-1,-3,-5].

function outlook(arr)
{
	var newarr=[];
	for (var i=0;i<arr.length;i++)
	{
		newarr.push(arr[i]*-1)
	}
	console.log("negative",newarr);
	return newarr;

}
outlook([-1,3,5])

//Always Hungry - Create a function that accepts an array, and prints "yummy" each time one of the values is equal to "food".  If no array elements are "food", then print "I'm hungry" once.
function hungry(array) 
{
    var c = 0;
    for (var i = 0; i < array.length; i++) 
    {
        if (array[i] === "food") 
        {
            console.log("yummy");
        }

         else 
         {
            c++;
       	 }
    }

    	if (c===array.length) 
    	{
        console.log("I'm hungry");
    	}
}

hungry(["food", 5, 6, "food"]);
hungry([5, 6]);

//Swap Toward the Center - Given array, swap first and last, third and third-to-last, etc.  Input[true,42,"Ada",2,"pizza"] becomes ["pizza", 42, "Ada", 2, true].  Change [1,2,3,4,5,6] to [6,2,4,3,5,1].



function swap(arr) 
{
    for (var i = 0; i < arr.length/2; i++) 
    {
        if (i % 2 === 0) 
        {
            var temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    } 
    console.log("After swapping ",arr); 
}
swap([true,42,"Ada",2,"pizza"]);
swap([1,2,3,4,5,6]);

//Scale the Array - Given an array arr and a number num, multiply all values in arr by num, and return the changed array arr.  For example, scaleArray([1,2,3],3) should return [3,6,9].
function scale(arr, num)
 {
  for (var i = 0; i < arr.length; i++)
   {
    arr[i] = arr[i]*num;
  }
  console.log("After scaling",arr);
  return arr;
}
scale([1,2,3],3)





















