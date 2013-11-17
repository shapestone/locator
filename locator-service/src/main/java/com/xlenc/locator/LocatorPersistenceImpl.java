package com.xlenc.locator;

import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.mapping.Mapper;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import com.xlenc.locator.api.LocatorState;
import org.bson.types.ObjectId;

/**
 * User: Michael Williams
 * Date: 12/15/12
 * Time: 9:59 AM
 */
public class LocatorPersistenceImpl extends BasicDAO<LocatorStateImpl, Object> implements LocatorPersistence {

    public LocatorPersistenceImpl(Mongo mongo, Morphia morphia, String dbName) {
        super(mongo, morphia, dbName);
    }

    @Override
    public LocatorState add(LocatorState locatorState) {
        final Key<LocatorStateImpl> save = super.save((LocatorStateImpl)locatorState);
        final Object id = save.getId();
        locatorState.setId(id.toString());
        return locatorState;
    }

    @Override
    public LocatorState read(LocatorState locatorState) {
        return super.findOne(Mapper.ID_KEY, new ObjectId(locatorState.getId()));
    }

    @Override
    public int delete(LocatorState locatorState) {
        final WriteResult writeResult = super.deleteById(new ObjectId(locatorState.getId()));
        return writeResult.getN();

    }

}
