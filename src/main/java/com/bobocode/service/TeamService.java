package com.bobocode.service;

import com.bobocode.dao.TeamRepository;
import com.bobocode.model.Team;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public void save(Team team) {
        teamRepository.save(team);
    }

    @Transactional(readOnly = true)
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public Team getOne(Long id) {
        return teamRepository.getOne(id);
    }

    public void update (Long id, Team team){
        if (!Objects.equals(id, team.getId())) {
            throw new IllegalStateException("Id parameter does not match account body value");
        }
        teamRepository.save(team);
    }

    public void remove (Team team){
        teamRepository.delete(team);
    }

}
