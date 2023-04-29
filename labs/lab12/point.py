#Ayoo Dada Lab 12 point.y
class Point:
    def __init__(self, x, y):
        self._xval = x
        self._yval = y
    
    def dist_from_origin(self):
        return (self._xval*self._xval) + (self._yval*self._yval)
    
    def __str__(self):
        return "(" + str(self._xval) + "," + str(self._yval) + ")"

p1 = Point(5, 3)
p2 = Point(5.3, 3)
print(p1, p1.dist_from_origin())
print(p2, p2.dist_from_origin())