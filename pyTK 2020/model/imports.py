#------------------------------------------------------------------------------
# Compiles all of the databases into one
#------------------------------------------------------------------------------
import sqlite3
import os

import model.team
import controller.windows.cteamdata as cteamdata

conn = sqlite3.connect('TabletData.db')
c = conn.cursor()

filePath = "C:\Scouting\pyTK 2019\Sqlite Database\\"


def create_table():
    global conn
    global c
    c.executescript('''
    CREATE TABLE IF NOT EXISTS CompetitionsAll( CompId TEXT, CompName TEXT,
              CompDate TEXT);
    CREATE TABLE IF NOT EXISTS MatchesAll( CompId TEXT, MatchNumber INTEGER,
              TeamNumber INTEGER, MatchPosition INTEGER,
              PRIMARY KEY(MatchNumber, TeamNumber, MatchPosition));
    CREATE TABLE IF NOT EXISTS PitDataAll( TeamNumber INTEGER PRIMARY KEY,
              Auto INTEGER, DriveBlindly INTEGER, Vision INTEGER, Camera INTEGER, Other INTEGER,
              TypeOfIntakeAndMech TEXT,
              TypeOfDriveTrain TEXT, ProgrammingLanguage TEXT, Comments TEXT, AverageSpeed TEXT,
              CoDriverExperience TEXT, DriverExperience TEXT, Climb TEXT);
    CREATE TABLE IF NOT EXISTS StatsAll( CompId TEXT, MatchNumber INTEGER,
              TeamNumber INTEGER, MatchPosition INTEGER,
              TopPCellAuto INTEGER, BottomPCellAuto INTEGER,
              CrossLineAuto INTEGER,
              DoesntMoveAuto INTEGER, IntakeAuto INTEGER,
              NoShowAuto INTEGER,
              TeleComments TEXT, TeleTopPC INTEGER,  
              TeleBottomPC INTEGER,
              TeleRotation INTEGER, TelePosition INTEGER,
              TeleHangSuccess INTEGER, TeleHangAttempt INTEGER,
              TeleHangNA INTEGER, TeleAssist INTEGER, 
              TeleAssisted INTEGER, TeleDefenseNone INTEGER,
              TeleDefenseSome INTEGER, TeleDefenseAll INTEGER,
              TeleDefenseGood INTEGER, TeleDefenseBad INTEGER, 
              TeleDefenseOk INTEGER, TeleDefenseNA INTEGER, RobotDisabled INTEGER,
              RedCard INTEGER, YellowCard INTEGER, 
              Fouls INTEGER, TechFouls INTEGER,
              ClimbSpeedFast INTEGER, ClimbSpeedMedium INTEGER, ClimbSpeedSlow INTEGER,
              ClimbSpeedNo INTEGER,
              PRIMARY KEY(MatchNumber, TeamNumber , MatchPosition));
    CREATE TABLE IF NOT EXISTS TeamsAll( TeamNumber INTEGER not null PRIMARY KEY, TeamName TEXT);
    CREATE TABLE IF NOT EXISTS Alliances( AllianceNum INTEGER not null PRIMARY KEY, TeamNum INTEGER);
    CREATE TABLE IF NOT EXISTS TeamInfo(TeamNum INTEGER PRIMARY KEY, NumMatch INTEGER,
                OffWS REAL,
                TotalWS REAL, NegWS REAL,
                PercentNoShow REAL,
                PercentFouls REAL, PercentTechFouls REAL,
                PercentYellowCard REAL, PercentRedCard REAL, 
                PercentRobotDisabled REAL, 
                TotalGamePiece REAL)''')

def add_data(model):
    model.imported = False
    global conn
    global c
    global filePath
    dirList = os.listdir(filePath)
    for filename in dirList:
        tabletconn = sqlite3.connect(filePath + filename)
        print(filename)
        tc = tabletconn.cursor()
        try:
            tc.execute('SELECT * FROM Matches')
            matches = tc.fetchall()
            c.executemany('INSERT OR REPLACE INTO MatchesAll VALUES (?, ?, ?, ?)', matches)
            model.imported = True
            print("successfully imported matches", model.imported)
        except Exception as e:
            print ("exception in matches",e)
            model.imported = False

        try:
            tc.execute('SELECT * FROM Teams')
            teams = tc.fetchall()
            c.executemany('INSERT OR REPLACE INTO TeamsAll VALUES (?, ?)', teams)
            model.imported = True
            print("successfully imported teams")
        except Exception as e:
            print ("exception in teams",e)
            model.imported = False

        try:
            tc.execute('SELECT * FROM Competitions')
            comps = tc.fetchall()
            c.executemany('INSERT OR REPLACE INTO CompetitionsAll VALUES (?, ?, ?)', comps)
            model.imported = True
            print("successfully imported comps")
        except Exception as e:
            print ("exception in comps",e)
            model.imported = False

        try:
            tc.execute('SELECT * FROM PitData')
            pitData = tc.fetchall()
            c.executemany('INSERT OR REPLACE INTO PitDataAll VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)', pitData)
            model.imported = True
            print("successfully imported pitdata") 
        except Exception as e:
            print ("exception in pitdata",e)
            model.imported = False
            exit

        try:
            tc.execute('SELECT * FROM Stats')
            stats = tc.fetchall()
            print(stats)
            if stats.__sizeof__() <= 0:
                print("No stats info to import")
                model.imported = True
            else:
                c.executemany('INSERT OR REPLACE INTO StatsAll VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)', stats)
                model.imported = True
                print("successfully imported stats") 
        except Exception as e:
            print ("exception in stats",e)

            
        tc.close()
        print("Model.imported=", model.imported)

def add_teamInfo(team):
    global conn
    global c
    teamInfo = []
    controller = cteamdata.TeamDataController()
    teamInfo.append(team.number)
    for x, y in controller.dataLabelVals:
        print(x)
        try:
            teamInfo.append(float(team.getAttr(x)))
        except:
            teamInfo.append(float((team.getAttr(x)[:team.getAttr(x).find("%")])))
    for x, y in controller.maxminLabelVals:
        print(x)
        teamInfo.append(int(team.Scores.getAttr(x)))
    temp = []
    print(teamInfo)
    temp.append(tuple(teamInfo))
    print(len(temp))
    c.executemany('INSERT OR REPLACE INTO TeamInfo VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)', temp)
    conn.commit()
    
    
def add_matches():
    global conn
    global c
    global filePath
    dirList = os.listdir(filePath)
    for filename in dirList:
        tabletconn = sqlite3.connect(filePath + filename)
        tc = tabletconn.cursor()
        
        tc.execute('SELECT * FROM Matches')
        matches = tc.fetchall()
        c.executemany('INSERT OR REPLACE INTO MatchesAll VALUES (?, ?, ?, ?)', matches)
    
def add_teams():
    global conn
    global c
    global filePath
    dirList = os.listdir(filePath)
    for filename in dirList:
        tabletconn = sqlite3.connect(filePath + filename)
        tc = tabletconn.cursor()
        
        tc.execute('SELECT * FROM Teams')
        teams = tc.fetchall()
        c.executemany('INSERT OR REPLACE INTO TeamsAll VALUES (?, ?, ?)', teams)
    
def add_competitions():
    global conn
    global c
    global filePath
    dirList = os.listdir(filePath)
    for filename in dirList:
        tabletconn = sqlite3.connect(filePath + filename)
        tc = tabletconn.cursor()
        
        tc.execute('SELECT * FROM Competitions')
        comps = tc.fetchall()
        c.executemany('INSERT OR REPLACE INTO CompetitionsAll VALUES (?, ?, ?)', comps)

def add_pitData():
    global conn
    global c
    global filePath
    dirList = os.listdir(filePath)
    for filename in dirList:
        tabletconn = sqlite3.connect(filePath + filename)
        tc = tabletconn.cursor()
        
        tc.execute('SELECT * FROM PitData')
        pitData = tc.fetchall()
        c.executemany('INSERT OR REPLACE INTO PitDataAll VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)', pitData)
def add_stats():
    global conn
    global c
    global filePath
    dirList = os.listdir(filePath)
  
    for filename in dirList:
        tabletconn = sqlite3.connect(filePath + filename)
        tc = tabletconn.cursor()
        
        tc.execute('SELECT * FROM Stats')
        stats = tc.fetchall()
        print(stats)
        c.executemany('INSERT OR REPLACE INTO StatsAll VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)',
            stats)

def clear_importData():
    model.imported = False
    model.pitImported = False
    # Team.available = []
    # Team.team_list = []


