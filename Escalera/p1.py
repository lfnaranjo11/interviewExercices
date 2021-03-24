def testCases():
    arr1=[1,1,1,1,3,7]
    arr3=[1,1,1,1,2,2,3,7]
    arr2=[1,4,5,6,3,2]
    print("for the array arr1 the max is:"+str(getMaxValue(arr1)))
    print("for the array arr2 the max is:"+str(getMaxValue(arr2)))
    print("for the array arr3 the max is:"+str(getMaxValue(arr3)))



def getMaxValue(arr):
    max=0
    arr.sort()
    #1,1,1,1,2,3
    for i in range(len(arr)):
        if(arr[i]>max):
            max+=1
    return max

def main():
    testCases()
if __name__ == "__main__":
    main()
