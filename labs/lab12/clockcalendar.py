from clock import Clock
from calendar import Calendar
 
class ClockCalendar(Clock, Calendar):
    def __init__(self, m, d, y, h, min, s):
        Calendar.__init__(self, d,m,y)
        Clock.__init__(self, h, min, s)
        

    def tick(self): 
        if(self.hours == 0 & self.minutes == 0 & self.seconds == 0):  
            Clock.tick(self)
        else:
            Clock.tick(self)
            if(self.hours == 0 & self.minutes == 0 & self.seconds == 0):        
                Calendar.advance(self)

    def __str__(self):
        return Calendar.__str__(self) + "," + Clock.__str__(self)   


x = ClockCalendar(12,31,2013,23,59,59)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)

x = ClockCalendar(2,28,1900,23,59,59)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)

x = ClockCalendar(2,28,2000,23,59,59)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)

x = ClockCalendar(2,7,2013,13,55,40)
print("One tick from ",x, end=" ")
x.tick()
print("to ", x)

x = ClockCalendar(12,24,2001,0,0,0)
print("One tick from",x, end=" ")
x.tick()
print("to", x)
