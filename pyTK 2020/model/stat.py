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
    noShow = 4

    robotDisabled = 23
    redCard = 24
    yellowCard = 25
    foul = 26
    techFoul = 27
    climb = 28
    
    for row in rows:
        for team in Team.team_list:
            if int(row[teamNum]) == team.number:
                team.Info.matches.append(row[matchNum])
                team.Info.noShow += row[noShow]
                team.Info.robotDisabled += row[robotDisabled]

                team.Scores.cargoShipH.append(row[cargoShipH])
                # team.Scores.climb.append(row[climb])

                team.Info.redCard += row[redCard]
                team.Info.yellowCard += row[yellowCard]

            if row[foul] > 1 or row[techFoul] > 1:
                team.Info.hasFoul += 1

            # print("added stats values for " + str(team.number))
        # print(row)

