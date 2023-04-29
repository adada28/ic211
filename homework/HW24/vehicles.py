#Ayoo Dada
#HW 24
class Vehicle:
    # constructor
    def __init__(self,type,model,mpg):
        # fields
        self.__type = type
        self.__model = model
        self.__mpg = mpg
        self._canfly = False
        self._numWheels = 4

    def doesItFly(self):
        return self._canfly

    def noise(self):
        return "hmmmm"

    def toString(self):
        return self.__model + " " + self.noise() + " does" + ("" if self.doesItFly() else " not") + " fly with " + str(self._numWheels) + " wheels."

# Car extends Vehicle
class Car(Vehicle):
    def __init__(self,type,model,mpg):
        super(Car,self).__init__(type,model,mpg)

    def noise(self):
        return "vroom"

# Truck extends Vehicle
class Truck(Vehicle):
    def __init__(self,type,model,mpg):
        super(Truck,self).__init__(type,model,mpg)

    def noise(self):
        return "bumbumbum"

# Motorcycle extends Vehicle
class Motorcycle(Vehicle):
    def __init__(self,type,model,mpg):
        super(Motorcycle,self).__init__(type,model,mpg)
        self._numWheels = 2

    def noise(self):
        return "errrrrrm"

# Plane extends Vehicle
class Plane(Vehicle):
    def __init__(self,type,model,mpg):
        super(Plane,self).__init__(type,model,mpg)
        self._numWheels = 3
        self._canfly = True

    def noise(self):
        return "woooosh"