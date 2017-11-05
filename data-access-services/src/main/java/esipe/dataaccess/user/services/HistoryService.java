package esipe.dataaccess.user.services;

import esipe.dataaccess.user.entities.HistoryEntity;
import esipe.dataaccess.user.repositories.HistoryRepository;
import esipe.dataaccess.user.repositories.UserRepository;
import esipe.models.HistoryDto;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author BOURGEOIS Thibault
 * Date     05/11/2017
 * Time     23:46
 */
@Service
public class HistoryService implements IHistoryService {

    DozerBeanMapper mapper = new DozerBeanMapper();

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<HistoryDto> getAllByAccountId(Long id) {
        return null;
    }

    @Override
    public List<HistoryDto> getAllByAccountIdAfterWeek(Long id) {
        return null;
    }

    @Override
    public HistoryDto create(HistoryDto historyDto) {
        return null;
    }
}
