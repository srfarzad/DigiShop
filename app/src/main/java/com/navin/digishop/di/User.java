package com.navin.digishop.di;

import javax.inject.Inject;

public class User {

    Contact contact;


    @Inject
    public User(Contact contact) {
        this.contact = contact;
    }


    public void addContact(String emailName) {
        contact.setEmail(emailName);
    }

    public String getContact() {
        return contact.getEmail();
    }

    public void deleteAccount() {
        contact.clearEmail();
    }


}
