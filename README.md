# RollingWindows

Given a stream of numbers and two window sizes, write code to calculate the rolling average and 
rolling maximum over those numbers for the two different window sizes.  

Given a stream containing the following values and the window sizes 3 and 5:

[1, 2, 3, 4, 5, 6]

the following tuples would be expected, where ‘None’ indicates that a value is not available, and would be ‘NaN’ in some languages:

(None, None, None, None)

(None, None, None, None)

(2,    3,    None, None) # 2 = average(1, 2, 3), 3 = max(1,2,3)

(3,    4,    None, None)

(4,    5,    3,    5)    # 4 = average(3,4,5), 5 = max(3,4,5), 3 = average(1,2,3,4,5), 5 = max(1,2,3,4,5) 

(5,    6,    4,    6)
