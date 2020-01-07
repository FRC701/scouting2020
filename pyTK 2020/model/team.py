#------------------------------------------------------------------------------
# team Module
#   -- Keeps track of valuable team information and scorings
#------------------------------------------------------------------------------

#------------------------------------------------------------------------------
# TeamInfo Class
#   -- Stores performance information
#------------------------------------------------------------------------------
class _TeamInfo(object):
    """Used to handle information for different teams."""

    def __init__(self):
        self.matches = []
        # Things that go into TeamInfo....... numbers that you want as percentages and totals
        # The numbers are set up so the numbers set as 0 are check boxes that incriment when set to true                     
        self.noShow = 0
        self.robotDisabled = 0
        self.redCard = 0
        self.yellowCard = 0
        self.fouls = 0
        self.techFouls = 0
        self.hasFoul = 0
        self.autoTopPCell = 0
        self.autoBottomPCell = 0
        self.autoCrossLine = 0
        self.autoDoesntMove = 0
        self.autoIntake = 0
        self.autoNoShow = 0
        self.teleComments = ""
        self.teleTopPC = 0
        self.teleBottomPC = 0
        self.teleRotation = 0
        self.telePosition = 0
        self.teleHangSuccess = 0
        self.teleHangAttempt = 0
        self.teleHangNA = 0
        self.teleAssist = 0
        self.teleAssisted = 0
        self.teleDefenseNone = 0
        self.teleDefenseSome = 0
        self.teleDefenseAll = 0
        self.teleDefenseGood = 0
        self.teleDefenseBad = 0

    def get_info(self):
        self.totalFoul =  self.fouls
        # you don't need to the the redCard, yellowCard, and disabled because they add up on their own
        self.totalTechFoul = self.techFouls
        # fouls are in arrays so they need to be added manually

        self.pNoShow = float(100*self.noShow)/float(len(self.matches)) if len(self.matches) else 0

        self.pDisabled = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0                             
        self.pRedCard = float(100*self.redCard)/float(len(self.matches)) if len(self.matches) else 0
        self.pYellowCard = float(100*self.yellowCard)/float(len(self.matches)) if len(self.matches) else 0
        self.pFoul = float(100*self.totalFoul)/float(len(self.matches)) if len(self.matches) else 0
        self.pTechFoul = float(100*self.totalTechFoul)/float(len(self.matches)) if len(self.matches) else 0
        # self.pAutoTopPCell = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        # self.pAutoBottomPCell = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pAutoCrossLine = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pAutoDoesntMove = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pAutoIntake = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pAutoNoShow = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        # self.pTeleTopPC = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        # self.pTeleBottomPC = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleRotation = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTelePosition = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleHangSucess = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleHangAttempt = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleHangNA = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleAssist = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleAssisted = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseNone = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseSome = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseAll = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseGood = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseBad = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseOk = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseNA = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0
        self.pNoShow = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0


    def getAttr(self, source):
        #return getattr(self, source)
        return None

#------------------------------------------------------------------------------
# TeamScores Class
#   -- stores data about a team's scores
#------------------------------------------------------------------------------
class _TeamScores(object):
    """Used to handle scoring data for different teams."""

    def __init__(self):
        self.autoTopPCell = []
        self.autoBottomPCell = []
        self.teleTopPC = []
        self.teleBottomPC = []

    def get_maxmin_scores(self):
        self.maxAutoTopPCell = max(self.autoTopPCell) if len(self.autoTopPCell) else 0
        self.maxAutoBottomPCell = max(self.autoBottomPCell) if len(self.autoBottomPCell) else 0
        self.maxTeleTopPC = max(self.teleTopPC) if len(self.teleTopPC) else 0
        self.maxTeleBottomPC = max(self.teleBottomPC) if len(self.teleBottomPC) else 0
        self.minAutoTopPCell = min(self.autoTopPCell) if len(self.autoTopPCell) else 0
        self.minAutoBottomPCell = min(self.autoBottomPCell) if len(self.autoBottomPCell) else 0
        self.minTeleTopPC = min(self.teleTopPC) if len(self.teleTopPC) else 0
        self.minTeleBottomPC = min(self.teleBottomPC) if len(self.teleBottomPC) else 0

    def get_avgOff_scores(self, matches=1):

        self.avgAutoTopPCell = float(sum(self.autoTopPCell))/float(matches) if matches else 0
        self.avgAutoBottomPCell = float(sum(self.autoBottomPCell)) / float(matches) if matches else 0
        self.avgTeleTopPC = float(sum(self.teleTopPC)) / float(matches) if matches else 0
        self.avgTeleBottomPC = float(sum(self.teleBottomPC)) / float(matches) if matches else 0

    def getAttr(self, source):
        return getattr(self, source)
#------------------------------------------------------------------------------
# TeamPitInfo Class
#   -- stores data unrelated to performance on the field
#------------------------------------------------------------------------------
class _TeamPitInfo(object):
    """Used to handle information about a teams chassis and other
       non-performance related information."""

    def __init__(self):
      self.answer1 = ""
      self.answer2 = ""
      self.answer3 = ""
      self.answer4 = ""
      self.answer5 = ""
      self.answer6 = ""

    def getAttr(self, source):
        return getattr(self, source)    

#------------------------------------------------------------------------------
# TeamRankings class
#   -- place to store ranking lists, for viewing team ranks
#------------------------------------------------------------------------------
class TeamRankings(object):
    """Used to keep track of rankings for each team."""

    fouls_rank = []
    techFouls_rank = []

    def __init__(self):
        print
        # no non-static class variables
        # team cannot track its own ranking:
            # rankings are defined by the user
            # rankings are dynamic, constantly changing to user request

    def getAttr(self, source):
        return getattr(self, source)

#------------------------------------------------------------------------------
# Team Class
#   -- stores and recalls team specific data
#------------------------------------------------------------------------------
class Team(object):
    """Store and recall data on a team from here."""

    team_list = []  # list holding all the teams currently loaded in the database
    available = []  # list holding all the teams not currently selected
    wanted = []     # list holding all the teams in our wanted list
    
    def __init__(self, num):
        self.number = num
        self.Info = _TeamInfo()
        self.Scores = _TeamScores()
        self.PitInfo = _TeamPitInfo()
        self.team_list.append(self)
        self.available.append(self)

        # a few of the final details predefined so as to satisfy predictions with null teams
        self.avgOff = 0
        self.avgDef = 0
        self.pOff = 0
        self.pDef = 0     

    def get_primary_details(self): # gets the offensive values of Team
        self.Info.get_info()
        self.Scores.get_avgOff_scores(len(self.Info.matches))
        self.Scores.get_maxmin_scores()

        #weighted scores calculations
            
        self.offensiveWS = str(round(((self.Info.pCrossHubLine/100.0)*4.0)

        self.negativeWS = str(round(((self.Info.pFoul/100.0)*-2.0)+((self.Info.pYellowCard/100.0)*-3.0)+((self.Info.pDisabled/100.0)*-10.0)
                                +((self.Info.pRedCard/100.0)*-10)+((self.Info.pTechFoul/100.0)*-11.0),2))

        self.totalWS = str(round(float(self.offensiveWS)+float(self.negativeWS), 2))

        matches = self.Info.matches
        self.numMatch = len(matches)
        self.pNoShow  = str(round(self.Info.pNoShow,2))  + "%"

        self.pRedCard = str(round(self.Info.pRedCard,2))  + "%"
        self.pYellowCard = str(round(self.Info.pYellowCard,2))  + "%"

        self.pHasFoul = str(int(100*self.Info.hasFoul)/len(matches)) + "%" if len(matches) else "0%"
        self.pFoul = str(round(self.Info.pFoul, 2)) + "%"
        self.pTechFoul = str(round(self.Info.pTechFoul, 2)) + "%"
        self.pDisabled = str(round(self.Info.pDisabled)) + "%"

        self.pAutoCrossLine = str(round(self.Info.pAutoCrossLine)) + "%"
        self.pAutoDoesntMove = str(round(self.Info.pAutoDoesntMove)) + "%"
        self.pAutoIntake = str(round(self.Info.pAutoIntake)) + "%"
        self.pAutoNoShow = str(round(self.Info.pAutoNoShow)) + "%"
        self.pTeleRotation = str(round(self.Info.pTeleRotation)) + "%"
        self.pTelePosition = str(round(self.Info.pTelePosition)) + "%"
        self.pTeleHangSuccess = str(round(self.Info.pTeleHangSucess)) + "%"
        self.pTeleHangAttempt = str(round(self.Info.pTeleHangAttempt)) + "%"
        self.pTeleHangNA = str(round(self.Info.pTeleHangNA)) + "%"
        self.pTeleAssist = str(round(self.Info.pTeleAssist)) + "%"
        self.pTeleAssisted = str(round(self.Info.pTeleAssisted)) + "%"
        self.pTeleDefenseNone = str(round(self.Info.pTeleDefenseNone)) + "%"
        self.pTeleDefenseSome = str(round(self.Info.pTeleDefenseSome)) + "%"
        self.pTeleDefenseAll = str(round(self.Info.pTeleDefenseAll)) + "%"
        self.pTeleDefenseGood = str(round(self.Info.pTeleDefenseGood)) + "%"
        self.pTeleDefenseBad = str(round(self.Info.pTeleDefenseBad)) + "%"
        self.pTeleDefenseOk = str(round(self.Info.pTeleDefenseOk)) + "%"
        self.pTeleDefenseNA = str(round(self.Info.pTeleDefenseNA)) + "%"

    def getAttr(self, source):
        return getattr(self, source)
