<template>
  <div id="contacts">
      <h2 v-if="contacts.length == 0">No contacts Found</h2>
      <table v-else>
          <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th></th>
            </tr>
          </thead>
          <tbody>
              <tr v-for="contact in contacts" :key="contact.contactId">
                <td>{{ contact.contactId }}</td>
                <td>{{ contact.firstName }} {{contact.lastName}}</td>
                <td>
                    <img src="../assets/icons/edit.png" v-on:click.prevent="newContact = contact" />
                    <img src="../assets/icons/delete.png" v-on:click.prevent="deleteContact(contact.contactId)"/>
                </td>
              </tr>
          </tbody>
      </table>
      <div class="addContact">
          <form v-on:submit.prevent="save">
              <div class="formElement">
                <label for="firstname">First Name:</label>
                <input type="text" id="firstname" v-model="newContact.firstName" />
              </div>
              <div class="formElement">
                <label for="lastname">Last Name:</label>
                <input type="text" id="lastname" v-model="newContact.lastName" />
              </div>
              <div class="formElement">
                  <input type="submit" :value="newContact.contactId ? 'Edit' : 'Add'" />
              </div>
          </form>
      </div>
  </div>
</template>

<script>
import contactService from '@/services/ContactService';

export default {
    data() {
        return {
            contacts: [],
            newContact: {}
        }
    },
    methods: {
        getAllContacts() {
            contactService.getContacts()
                .then( response => {
                    this.contacts = response.data;
                })
        },
        save() {
            if (this.newContact.contactId) {
                this.updateContact();
            } else {
                this.addContact();
            }
        },
        addContact() {
            contactService.addContact(this.newContact)
                .then( response => {
                    if (response.status === 200) {
                        this.getAllContacts();
                    }
                    this.newContact = {};
                })
                .catch ( err => console.error(err) );
        },
        updateContact() {
            contactService.updateContact(this.newContact)
                .then (response => {
                    if (response.status === 200) {
                        this.getAllContacts();
                    }
                    this.newContact = {};
                })
                .catch( err => console.error(err) );
        },
        deleteContact(id) {
           contactService.deleteContact(id)
            .then( response => {
                if (response.status === 200) {
                    this.getAllContacts();
                }
            })
            .catch( err => console.error(err) );
        }
    },
    created() {
        this.getAllContacts();
    }
}
</script>

<style>
#contacts {
    display: flex;
    justify-content: center;
    align-content: center;
    flex-direction: column;
}

th:first-child, td:first-child {
    width: 75px;
    text-align:center;
}
table {
    width: 50%;
    margin: 0 auto;
}
td {
    text-align: left;
}

tbody tr:nth-child(even) {
    background-color: lightgray;
}

img {
    width: 20px;
    padding-left: 10px;
}

div.addContact {
    width: 50%;
    margin: 0 auto;
    margin-top: 20px;
}

div.formElement {
    margin-bottom: 10px;
}
label {
    padding-right: 10px;
}
</style>