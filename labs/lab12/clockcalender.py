from clock import Clock
from calendar import Calendar
 
class ClockCalendar:
    def __init__(self, m, d, y, h, min, s):
        self._month = m
        self._day = d
        self._year = y 
        self._hour = h
        self._minute = min 
        self._second = s

c = ClockCalendar(4, 23, 2019, 9, 55, 0)
print(c.days)
print(c.months)
print(c.years)
print(c.hours)
print(c.minutes)
print(c.seconds)