package application.dto;

import application.domain.Fighter;


public class FighterDTOMapper {

    public static FighterDTO mapToDto(Fighter fighter){
        FighterDTO dto = new FighterDTO();
        dto.setId(fighter.getId());
        dto.setName(fighter.getName());
        dto.setBirthDate(fighter.getBirthDate());
        dto.setHeight(fighter.getHeight());
        dto.setNationality(fighter.getNationality());
        dto.setSex(fighter.getSex());
        dto.setWeight(fighter.getWeight());
        dto.setAttack(fighter.getStats().getAttack());
        dto.setDefense(fighter.getStats().getDefense());
        dto.setStamina(fighter.getStats().getStamina());
        dto.setVictories(fighter.getStats().getVictories());
        dto.setLosses(fighter.getStats().getLosses());
        dto.setTournaments(fighter.getTournaments());
        return dto;
    }

}
