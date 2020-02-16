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
        self.teleComments = ""
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
        self.teleDefenseNA = 0
        self.teleDefenseOk = 0
        self.teleClimbSpeedFast = 0
        self.teleClimbSpeedMedium = 0
        self.teleClimbSpeedSlow = 0
        self.teleClimbSpeedNo = 0

    def get_info(self):
        self.totalFoul = self.fouls
        # you don't need to the the redCard, yellowCard, and disabled because they add up on their own
        self.totalTechFoul = self.techFouls
        # fouls are in arrays so they need to be added manually

        self.pNoShow = float(100*self.noShow)/float(len(self.matches)) if len(self.matches) else 0

        self.pDisabled = float(100*self.robotDisabled)/float(len(self.matches)) if len(self.matches) else 0                             
        self.pRedCard = float(100*self.redCard)/float(len(self.matches)) if len(self.matches) else 0
        self.pYellowCard = float(100*self.yellowCard)/float(len(self.matches)) if len(self.matches) else 0
        self.pFoul = float(100*self.totalFoul)/float(len(self.matches)) if len(self.matches) else 0
        self.pTechFoul = float(100*self.totalTechFoul)/float(len(self.matches)) if len(self.matches) else 0
        # self.pAutoTopPCell = float(100*self.autoTopPCell)/float(len(self.matches)) if len(self.matches) else 0
        # self.pAutoBottomPCell = float(100*self.autoBottomPCell)/float(len(self.matches)) if len(self.matches) else 0
        self.pAutoCrossLine = float(100*self.autoCrossLine)/float(len(self.matches)) if len(self.matches) else 0
        self.pAutoDoesntMove = float(100*self.autoDoesntMove)/float(len(self.matches)) if len(self.matches) else 0
        self.pAutoIntake = float(100*self.autoIntake)/float(len(self.matches)) if len(self.matches) else 0
        # self.pTeleTopPC = float(100*self.teleTopPC)/float(len(self.matches)) if len(self.matches) else 0
        # self.pTeleBottomPC = float(100*self.teleBottomPC)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleRotation = float(100*self.teleRotation)/float(len(self.matches)) if len(self.matches) else 0
        self.pTelePosition = float(100*self.telePosition)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleHangSucess = float(100*self.teleHangSuccess)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleHangAttempt = float(100*self.teleHangAttempt)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleHangNA = float(100*self.teleHangNA)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleAssist = float(100*self.teleAssist)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleAssisted = float(100*self.teleAssisted)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseNone = float(100*self.teleDefenseNone)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseSome = float(100*self.teleDefenseSome)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseAll = float(100*self.teleDefenseAll)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseGood = float(100*self.teleDefenseGood)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseBad = float(100*self.teleDefenseBad)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseOk = float(100*self.teleDefenseOk)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleDefenseNA = float(100*self.teleDefenseNA)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleClimbSpeedFast = float(100 * self.teleClimbSpeedFast)/float(len(self.matches)) if len(self.matches) else 0
        self.pTeleClimbSpeedMedium = float(100 * self.teleClimbSpeedMedium) / float(len(self.matches)) if len(self.matches) else 0
        self.pTeleClimbSpeedSlow = float(100 * self.teleClimbSpeedSlow) / float(len(self.matches)) if len(self.matches) else 0
        self.pTeleClimbSpeedNo = float(100 * self.teleClimbSpeedNo) / float(len(self.matches)) if len(self.matches) else 0

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

    def get_avg_off_scores(self, matches=1):
        self.avgAutoTopPCell = float(sum(self.autoTopPCell))/float(matches) if matches else 0
        self.avgAutoBottomPCell = float(sum(self.autoBottomPCell))/float(matches) if matches else 0
        self.avgTeleBottomPC = float(sum(self.teleBottomPC))/float(matches) if matches else 0
        self.avgTeleTopPC = float(sum(self.teleTopPC))/float(matches) if matches else 0

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
        self.typeOfIntakeAndMech = ""
        self.typeOfDriveTrain = ""
        self.programmingLanguage = ""
        self.averageSpeed = ""
        self.ballsDuringAuto = ""
        self.autoAnswer = ""
        self.autoAnswerYes = 0
        self.autoAnswerNo = 0
        if self.autoAnswerYes == 1:
            self.autoAnswer += "has an auto "
        if self.autoAnswerNo == 1:
            self.autoAnswer += "does not have an auto "
        self.actionsDuringAuto = ""
        self.autoCrossLinePit = 0
        self.autoIntakeBallsPit = 0
        self.autoScoreLower = 0
        self.autoScoreOuter = 0
        self.autoScoreInner = 0
        if self.autoCrossLinePit == 1:
            self.actionsDuringAuto += "cross Initiation Line "
        if self.autoIntakeBallsPit == 1:
            self.actionsDuringAuto += "intakes balls "
        if self.autoScoreLower == 1:
            self.actionsDuringAuto += "lower port "
        if self.autoScoreOuter == 1:
            self.actionsDuringAuto += "outer port "
        if self.autoScoreInner == 1:
            self.actionsDuringAuto += "inner port "
        self.whatPortTheyCanScoreIn = ""
        self.scoreBottomPort = 0
        self.scoreOuterPort = 0
        self.scoreInnerPort = 0
        if self.scoreBottomPort == 1:
            self.whatPortTheyCanScoreIn += "bottom port "
        if self.scoreOuterPort == 1:
            self.whatPortTheyCanScoreIn += "outer port "
        if self.scoreInnerPort == 1:
            self.whatPortTheyCanScoreIn += "inner port "
        self.controlPanelCapabilities = ""
        self.positionControlPanel = 0
        self.rotateControlPanel = 0
        if self.positionControlPanel == 1:
            self.controlPanelCapabilities += "position "
        if self.rotateControlPanel == 1:
            self.controlPanelCapabilities += "rotate "
        self.endGame = ""
        self.assistClimb = 0
        self.parkRobot = 0
        self.robotClimb = 0
        if self.assistClimb == 1:
            self.endGame += "assist climb "
        if self.parkRobot == 1:
            self.endGame += "parks robot "
        if self.robotClimb == 1:
            self.endGame += "climb "
        self.intakeFromGround = ""
        self.powerCellIntakeYes = 0
        self.powerCellIntakeNo = 0
        if self.powerCellIntakeYes == 1:
            self.intakeFromGround += "can intake "
        if self.powerCellIntakeNo == 1:
            self.intakeFromGround += "cannot intake "
        self.robotDefense = ""
        self.defenseRobotYes = 0
        self.defenseRobotNo = 0
        if self.defenseRobotYes == 1:
            self.robotDefense += "robot can defend "
        if self.defenseRobotNo == 1:
            self.robotDefense += "robot cannot defend "



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
        self.Scores.get_avg_off_scores(len(self.Info.matches))
        self.Scores.get_maxmin_scores()

        #weighted scores calculations
            
        self.offensiveWS = str(round(((self.Info.pAutoCrossLine/100.0)*4.0)))

        self.negativeWS = str(round(((self.Info.pFoul/100.0)*-2.0)+((self.Info.pYellowCard/100.0)*-3.0) +
                                    ((self.Info.pDisabled/100.0)*-10.0)
                                    + ((self.Info.pRedCard/100.0)*-10)+((self.Info.pTechFoul/100.0)*-11.0), 2))

        self.totalWS = str(round(float(self.offensiveWS)+float(self.negativeWS), 2))

        matches = self.Info.matches
        self.numMatch = len(matches)
        self.pNoShow = str(round(self.Info.pNoShow, 2)) + "%"

        self.pRedCard = str(round(self.Info.pRedCard, 2)) + "%"
        self.pYellowCard = str(round(self.Info.pYellowCard, 2)) + "%"

        self.pHasFoul = str(int(100*self.Info.hasFoul)/len(matches)) + "%" if len(matches) else "0%"
        self.pFoul = str(round(self.Info.pFoul, 2)) + "%"
        self.pTechFoul = str(round(self.Info.pTechFoul, 2)) + "%"
        self.pDisabled = str(round(self.Info.pDisabled)) + "%"

        self.pAutoCrossLine = str(round(self.Info.pAutoCrossLine)) + "%"
        self.pAutoDoesntMove = str(round(self.Info.pAutoDoesntMove)) + "%"
        self.pAutoIntake = str(round(self.Info.pAutoIntake)) + "%"
        self.pTeleRotation = str(round(self.Info.pTeleRotation)) + "%"
        self.pTelePosition = str(round(self.Info.pTelePosition)) + "%"
        self.pTeleHangSucess = str(round(self.Info.pTeleHangSucess)) + "%"
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
        self.pTeleClimbSpeedFast = str(round(self.Info.pTeleClimbSpeedFast)) + "%"
        self.pTeleClimbSpeedMedium = str(round(self.Info.pTeleClimbSpeedMedium)) + "%"
        self.pTeleClimbSpeedSlow = str(round(self.Info.pTeleClimbSpeedSlow)) + "%"
        self.pTeleClimbSpeedNo = str(round(self.Info.pTeleClimbSpeedNo)) + "%"

        self.avgAutoTopPCell = str(round(self.Scores.avgAutoTopPCell))
        self.avgAutoBottomPCell = str(round(self.Scores.avgAutoBottomPCell))
        self.avgTeleBottomPC = str(round(self.Scores.avgTeleBottomPC))
        self.avgTeleTopPC = str(round(self.Scores.avgTeleTopPC))

    def getAttr(self, source):
        return getattr(self, source)
