import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {
    
    getContacts() {
        return http.get('/contacts');
    },
    addContact(contact) {
        return http.post('/contacts', contact);
    },
    updateContact(contact) {
        return http.put(`/contacts/${contact.contactId}`, contact);
    },
    deleteContact(contactId) {
        return http.delete(`/contacts/${contactId}`);
    }



}