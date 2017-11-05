package esipe.dataaccess.user.services;

import esipe.models.HistoryDto;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     23:43
 */
public interface IHistoryService {
    List<HistoryDto> getAllByAccountId(Long id);
    List<HistoryDto> getAllByAccountIdAfterWeek(Long id);
    HistoryDto create(HistoryDto historyDto);
}
