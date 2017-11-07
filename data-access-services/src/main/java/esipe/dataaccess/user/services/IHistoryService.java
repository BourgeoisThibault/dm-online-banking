package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.UserEntity;
import esipe.models.HistoryDto;
import esipe.models.UserDto;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     23:43
 */
public interface IHistoryService {
    List<HistoryDto> getAllByAccountId(Long id);
    List<HistoryDto> getAllByUserId(UserDto userDto);
    void create(HistoryDto historyDto);
    Boolean allowGetTransaction(Long id, Double amount);
}
