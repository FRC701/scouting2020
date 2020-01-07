#------------------------------------------------------------------------------
# cranking module
#   -- contains the functions and classes for controlling the ranking window
#------------------------------------------------------------------------------
from tkinter import *

from model.calculate import *

#------------------------------------------------------------------------------
# get_none function
#   -- passes through so that a None list can delete all of its contents
#------------------------------------------------------------------------------
def get_none(sort=None,rev=None):
    pass

#------------------------------------------------------------------------------
# RankingController Class
#   -- used to get and set data for Ranking objects and their Listings
#------------------------------------------------------------------------------
class RankingController():

    # use these to index values to display, use the system: ("key",term)
    # where key corredsponds to a value in self.rankingTypes and term is
    # the function to call when that option is selected
    rankingTypes = ["None",
                    "Auto Top Power Cell",
                    "Auto Bottom Power Cell",
                    "Tele Top Power Cell",
                    "Tele Bottom Power Cell"]

    rankingIndex = [("None", get_none),
                    ("Auto Top Power Cell", get_autoTopPCell_rank),
                    ("Auto Bottom Power Cell", get_autoBottomPCell_rank),
                    ("Tele Top Power Cell", get_teleTopPC_rank),
                    ("Tele Bottom Power Cell", get_teleBottomPC_rank)]

    sortOptions = [("Maximum","max"),("Average","avg"),("Minimum","min")]

    def __init__(self):
        self.sort = StringVar()
        self.sort.set("avg")
        self.rev = BooleanVar()
        self.rev.set(1)
        self.data = None

    def load_rankings(self,kind="None"):
        for value, func in self.rankingIndex:
            if value==kind:
                self.data = func(sort=self.sort.get(),rev=self.rev.get())
                break
