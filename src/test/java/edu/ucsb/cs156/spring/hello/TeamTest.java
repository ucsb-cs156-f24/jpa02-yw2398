package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equal_return_same_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equal_return_false_different_type() {
        String testTeam = "test false team";
        assertEquals(false, team.equals(testTeam));
    }

    @Test
    public void equals_returns_true_same_team_and_mambers() {
        Team testTeam1 = new Team("team1");
        testTeam1.addMember("Am");
        testTeam1.addMember("Ca");

        Team testTeam2 = new Team("team1");
        testTeam2.addMember("Am");
        testTeam2.addMember("Ca");
        
        assertEquals(true, testTeam1.equals(testTeam2));
    }

    @Test
    public void equals_returns_false_different_members() {
        Team testTeam1 = new Team("team1");
        testTeam1.addMember("Am");
        testTeam1.addMember("Ca");

        Team testTeam2 = new Team("team1");
        testTeam2.addMember("Bob");
        testTeam2.addMember("Emily");
        assertEquals(testTeam1.equals(testTeam2), false);
    }

    @Test 
    public void equals_returns_false_different_teamname() {
        Team testTeam1 = new Team("team1");
        testTeam1.addMember("Am");
        testTeam1.addMember("Ca");

        Team testTeam2 = new Team("team2");
        testTeam2.addMember("Am");
        testTeam2.addMember("Ca");
        assertEquals(testTeam1.equals(testTeam2), false);
    }

    @Test 
    public void equals_returns_false_different() {
        Team tesTeam = new Team("not team-08");
        tesTeam.addMember("Not Amber");
        assertEquals(team.equals(tesTeam), false);
    }

    @Test
    public void hashCode_returns_correct() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
        assertEquals(t1.hashCode(), (t1.name.hashCode() | t1.members.hashCode()));
    }

}
