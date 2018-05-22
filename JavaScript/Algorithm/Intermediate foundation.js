// Sigma - Implement function sigma(num) that given a number, returns the sum of all positive integers up to number (inclusive).  Ex: sigma(3) = 6 (or 1+2+3); sigma(5) = 15 (or 1+2+3+4+5).


function sigma (num)
{
	var sum=0;
	for(var i=0;i<=num;i++)
	{
		sum=sum+i;
	}
	return sum;
}
console.log(sigma(3));
console.log(sigma(5));


//Factorial - Write a function factorial(num) that, given a number, returns the product (multiplication) of all positive integers from 1 up to number (inclusive).  For example, factorial(3) = 6 (or 1*2*3); factorial(5) = 120 (or 1*2*3*4*5).
function factorial (num)
{
	var  res=1;
	for(var i=1;i<=num;i++)
	{
		res=res*i;
	}
	console.log("Factorial",res);
	return res;
}
factorial(3);
factorial(5);

//Fibonacci - Create a function to generate Fibonacci numbers.  In this famous mathematical sequence, each number is the sum of the previous two, starting with values 0 and 1.  Your function should accept one argument, an index into the sequence (where 0 corresponds to the initial value, 4 corresponds to the value four later, etc).  Examples: fibonacci(0) = 0 (given), fibonacci(1) = 1 (given), fibonacci(2) = 1 (fib(0)+fib(1), or 0+1), fibonacci(3) = 2 (fib(1) + fib(2)3, or 1+1), fibonacci(4) = 3 (1+2), fibonacci(5) = 5 (2+3), fibonacci(6) = 8 (3+5), fibonacci(7) = 13 (5+8).
function fibonacci(index) 
{
    var arr = [0, 1];
    for (var i = 2; i < index; i++) {
        arr[i] = arr[i - 1] + arr[i - 2];
    }
    console.log("Fibonacci",arr);
}
  
fibonacci(7);


//Array: Second-to-Last: Return the second-to-last element of an array. Given [42, true, 4, "Liam", 7], return "Liam".  If array is too short, return null.

function returnArray(arr) 
{
    if (arr.length > 2) 
    {
      return arr[arr.length - 2];
    } 

    else
    {
      return null;
    }
}

returnArray([42, true, 4, "Liam", 7]);

//Array: Nth-to-Last: Return the element that is N-from-array's-end.  Given ([5,2,3,6,4,9,7],3), return 4.  If the array is too short, return null.
function nth(arr, value)
 {
    if (arr.length > 2) 
    {
      return (arr[arr.length - value]);

    } 
    else 
    {
      return null;
    }
}

console.log(nth([5,2,3,6,4,9,7],3));

//Array: Second-Largest: Return the second-largest element of an array. Given [42,1,4,3.14,7], return 7.  If the array is too short, return null.
function secondLargest(arr)
{
	var max=null;
	var second=null;


	for (var i = 0; i < arr.length; i++) 
	{
      if (arr[i] > max) 
      {
        max = arr[i];
      }
    }

    for (var j = 0; j < arr.length; j++) 
    {
      if ((arr[j] > second) && (arr[j] < max))
      {
        second = arr[j];
      }
    }
    console.log(second);
    return second;


}
secondLargest([42,1,4,3,14,7])

//Double Trouble: Create a function that changes a given array to list each existing element twice, retaining original order.  Convert [4, "Ulysses", 42, false] to [4,4, "Ulysses", "Ulysses", 42, 42, false, false].

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

  console.log(arr);
 
}
double([4, "Ulysses", 42, false]);








