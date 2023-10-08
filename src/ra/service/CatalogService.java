package ra.service;

import ra.model.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogService  implements IService<Catalog,Integer>{
    private List<Catalog> catalogs = new ArrayList<>();
    @Override
    public List<Catalog> getAll() {
      return catalogs;
    }

    @Override
    public void save(Catalog catalog) {
        catalogs.add(catalog);

    }

    @Override
    public Catalog findById(Integer catalogId) {
        for (Catalog catalog: catalogs) {
           if (catalog.getCatalogId() == catalogId){
            return catalog;
           }
        }
        return null;
    }

    @Override
    public void delete(Integer catalogId) {
        Catalog catalogDelete = null;
        for (Catalog catalog: catalogs) {
            if (catalog.getCatalogId() == catalogId){
                catalogDelete = catalog;
                break;
            }
        }
        if (catalogDelete != null){
            catalogs.remove(catalogDelete);
        }

    }
}
