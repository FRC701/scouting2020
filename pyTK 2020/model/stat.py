import sqlite3
from model.team import *

conn = sqlite3.connect('TabletData.db')
c = conn.cursor()

def get_teams():
    global c
    c.execute('SELECT TeamNumber FROM TeamsAll')
    teams = c.fetchall()
    #save all teams as new team objects for data to be added later
    for t in teams:
        Team(t[0])
        print ("Added Team #: " + str(t[0]))
    return teams

def get_pitTeams():
    global c
    for t in get_teams():
        c.execute('SELECT * FROM PitDataAll WHERE TeamNumber = ' + str(t[0]))
        rowPit = c.fetchone()
        rowsForTeamPit = []

        while rowPit is not None:
            rowsForTeamPit.append(rowPit)
            rowPit = c.fetchone()


def populate_teaminfo():
    global c
    for t in get_teams():
        c.execute('SELECT * FROM StatsAll WHERE TeamNumber = ' + str(t[0]))
        rowStats = c.fetchone()
        rowsForTeamStats = []
        
        while rowStats is not None:
            rowsForTeamStats.append(rowStats)
            rowStats = c.fetchone()
            
        store_stats(rowsForTeamStats)        
        
def store_stats(rows):
    #index
    matchNum=1
    teamNum=2
    matchPosition = 3
    autoTopPCell = 4
    autoBottomPCell = 5
    autoCrossLine = 6
    autoDoesntMove = 7
    autoIntake = 8
    noShow = 9
    teleComments = 10
    teleTopPC = 11
    teleBottomPC = 12
    teleRotation = 13
    telePosition = 14
    teleHangSuccess = 15
    teleHangAttempt = 16
    teleHangNA = 17
    teleAssist = 18
    teleAssisted = 19
    teleDefenseNone = 20
    teleDefenseSome = 21
    teleDefenseAll = 22
    teleDefenseGood = 23
    teleDefenseBad = 24
    teleDefenseOk = 25
    teleDefenseNA = 26
    robotDisabled = 27
    redCard = 28
    yellowCard = 29
    foul = 30
    techFoul = 31
    climbSpeedFast = 32
    climbSpeedMedium = 33
    climbSpeedSlow = 34
    climbSpeedNo = 35
    
    for row in rows:
        for team in Team.team_list:
            if int(row[teamNum]) == team.number:
                team.Info.matches.append(row[matchNum])
                team.Info.noShow += row[noShow]
                team.Info.robotDisabled += row[robotDisabled]
                team.Info.autoCrossLine += row[autoCrossLine]
                team.Info.autoDoesntMove += row[autoDoesntMove]
                team.Info.autoIntake += row[autoIntake]
                team.Info.teleRotation += row[teleRotation]
                team.Info.telePosition += row[telePosition]
                team.Info.teleHangSuccess += row[teleHangSuccess]
                team.Info.teleHangAttempt += row[teleHangAttempt]
                team.Info.teleHangNA += row[teleHangNA]
                team.Info.teleAssist += row[teleAssist]
                team.Info.teleAssisted += row[teleAssisted]
                team.Info.teleDefenseNone += row[teleDefenseNone]
                team.Info.teleDefenseSome += row[teleDefenseSome]
                team.Info.teleDefenseAll += row[teleDefenseAll]
                team.Info.teleDefenseNA += row[teleDefenseNA]
                team.Info.teleDefenseGood += row[teleDefenseGood]
                team.Info.teleDefenseBad += row[teleDefenseBad]
                team.Info.teleDefenseOk += row[teleDefenseOk]
                team.Info.teleClimbSpeedFast += row[climbSpeedFast]
                team.Info.teleClimbSpeedMedium += row[climbSpeedMedium]
                team.Info.teleClimbSpeedSlow += row[climbSpeedSlow]
                team.Info.teleClimbSpeedNo += row[climbSpeedNo]
                team.Info.robotDisabled += row[robotDisabled]

                team.Scores.autoTopPCell.append(row[autoTopPCell])
                team.Scores.autoBottomPCell.append(row[autoBottomPCell])
                team.Scores.teleTopPC.append(row[teleTopPC])
                team.Scores.teleBottomPC.append(row[teleBottomPC])
                # team.Scores.climb.append(row[climb])

                team.Info.redCard += row[redCard]
                team.Info.yellowCard += row[yellowCard]

            if row[foul] > 1 or row[techFoul] > 1:
                team.Info.hasFoul += 1

            # print("added stats values for " + str(team.number))
        # print(row)

