package com.testing.merav.infra;

public enum APICalls {

    CREATE_USER {
        @Override
        public String toString(){ return "createUser";}
    },

    DELETE_USER{
        @Override
        public String toString() {return  "deleteUser";}
    },

    LOGIN{
        @Override
        public String toString() {return  "login";}
    },

    LOGOUT{
        @Override
        public String toString() {return  "logout";}
    },

    OWNERS{
        @Override
        public String toString() {return  "owners";}
    },

    OWNER{
        @Override //TODO needs to complete
        public String toString() {return  "owner";}
    }
}
