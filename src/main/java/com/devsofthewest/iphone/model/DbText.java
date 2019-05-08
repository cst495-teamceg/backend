package com.devsofthewest.iphone.model;
import com.google.appengine.api.datastore.Text;

class DbText extends Text
{
    @Override
    public String toString()
    {
        return this.getValue();
    }
}