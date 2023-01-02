
##
## Class PetError -- complete
##

class PetError( ValueError ):
    
    pass

##
## Class Pet -- not complete
##

class Pet( object ):
    
    def __init__( self, species=None, name="" ):
        
        if species.lower() in ['dog', 'cat', 'horse', 'gerbil', 'hamster', 'ferret']:
            
            self.species_str = species.title()
            self.name_str = name.title()
            
        else:
            
            raise PetError()
            
    def __str__( self ):
        
        if self.name_str != "":
            result_str = "Species of {:s}, Named {:s}".format(self.species_str.title(), self.name_str.title())
        else:
            result_str = "Species of {:s}, unnamed".format(self.species_str.title())
            
        return result_str

##
## Class Dog -- not complete
##

class Dog( Pet ):

    def __init__(self, name="", chases="Cats"):
        
        Pet.__init__(self,'Dog',name)
        self.chases = chases.title()
    
    def __str__(self):
        
        if (self.name_str != ""):
            return "Species of: Dog, named {:s}, chases {:s}".format(self.name_str.title(), self.chases.title())
        else:
            return "Species of: Dog, unnamed, chases {:s}".format(self.chases.title())

##
## Class Cat -- not complete
##

class Cat( Pet ):
    
    def __init__(self, name="", hates="Dogs"):
        
        Pet.__init__(self,'Cat', name)
        self.hates = hates.title()
        
    def __str__(self):
        
        if (self.name_str != ""):
            return "Species of: Cat, named {:s}, hates {:s}".format(self.name_str.title(), self.hates.title())
        else:
            return "Species of: Cat, unnamed, hates {:s}".format(self.hates.title())


