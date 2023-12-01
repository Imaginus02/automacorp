<template>
  <div class="windows-list pt-3">
    <PopupModal ref="popup" @confirm="removeWindow"></PopupModal>
    <div class="d-flex mb-2">
      <button type="button" class="btn btn-primary" v-if="!formVisibility" @click="toggleFormVisibility">Create new window</button>
    </div>
    <WindowForm v-if="formVisibility" @hide-form="toggleFormVisibility" @new-window="addWindow"></WindowForm>

    <windows-list-item v-if="!formVisibility" v-for="window in windows" :window="window" :key="window.id" @window-updated="updateWindow" @window-delete="askForDeletion">
    </windows-list-item>
  </div>
</template>


<script>
import axios from 'axios';
import { API_HOST } from '../../config';
import WindowsListItem from './WindowsListItem.vue';
import PopupModal from "../PopupModal.vue";
import {ref} from "vue";
import WindowForm from "./WindowForm.vue";

export default {
  components: {
    WindowForm,
    PopupModal,
    WindowsListItem
  },
  visible: false,
  name: 'WindowsList',
  data: function () {
    return {
      /*Variable in charge of the visibility of the form and hiding of the window list*/
      formVisibility: false,
      /* Initialize windows with an empty array, while waiting for actual data to be retrieved from the API */
      windows: []
    }
  },

  created: async function () {
    let response = await axios.get(`${API_HOST}/api/windows`, {
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
        'Access-Control-Allow-Credentials': 'true'
      }
    });
    this.windows = response.data;
  },
  methods: {
    updateWindow(newWindow) {
      /* Find the place of window object with the same Id in the array, and replace it */
      let index = this.windows.findIndex(window => window.id === newWindow.id);
      console.log("update window", newWindow);
      this.windows.splice(index, 1, newWindow);
    },
    addWindow(newWindow) {
      this.toggleFormVisibility();
      this.windows.push(newWindow);
    },
    async removeWindow() {
      const popupRef = this.$refs.popup;
      console.log('Removing window with ID:', popupRef.concernedWindow);

      try {
        await popupRef.open();
        console.log('User confirmed deletion.');
        console.log('Attempting to delete window');

        await axios.delete(`${API_HOST}/api/windows/${popupRef.concernedWindow}`);
        let index = this.windows.findIndex(window => window.id === popupRef.concernedWindow);
        this.windows.splice(index, 1);
        console.log('Window deleted');
      } catch (error) {
        // Handle the error if the user cancels or if the deletion request fails
        console.error('Error deleting window:', error);
      }
      popupRef.close();
    },
    askForDeletion(windowId) {
      this.$refs.popup.open();
      this.$refs.popup.changeWindow(windowId);
    },
    toggleFormVisibility() {
      this.formVisibility = !this.formVisibility;
      this.$nextTick(() => this.$forceUpdate());
    },
  }
}
</script>

<style lang="scss">
.modal-background {
  position: fixed;
  background-color: rgba(0, 0, 0, 0.3);
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}

</style>
