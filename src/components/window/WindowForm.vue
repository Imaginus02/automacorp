<template>
  <div class="alert alert-danger" role="alert" v-if="alertVisibility">
    <p v-if="backendError">An unexpected problem occured, the window could not be created</p>
    <p v-if="missingArguments">Required case missing</p>
  </div>

  <form @submit.prevent="handleSubmit">
    <button type="submit" class="btn btn-primary me-2" >Create</button>
    <button type="button" class="btn btn-danger" @click="cancelForm">Cancel</button>
    <input v-model="windowName" type="text" class="form-control mb-3 space-between-elements" placeholder="Window name">
    <select v-model="selectedRoom" class="form-select">
      <option disabled value=null>-- Select room --</option>
      <option v-for="(room) in rooms" :value=room.id>Room {{room.name}}</option>
    </select>
  </form>
</template>


<script>
  import axios from "axios";
  import {API_HOST} from "../../config";

  export default {
    emits: ["hide-form", "new-window"],
    data() {
      return {
        alertVisibility: false,
        backendError: false,
        missingArguments: false,
        windowName: '',
        selectedRoom: null,
        rooms: []
      };
    },
    created: async function () {
      let response = await axios.get(`${API_HOST}/api/rooms`, {
        headers: {
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Headers': '*',
          'Access-Control-Allow-Credentials': 'true'
        }
      });
      this.rooms = response.data;
    },
    methods: {
      cancelForm() {
        this.$emit('hide-form');
      },
      async handleSubmit() {
        // Handle the form submission here
        console.log('Window Name:', this.windowName);
        console.log('Selected Room:', this.selectedRoom);

        // Reset form data or perform further actions as needed
        if (this.windowName === '' || this.selectedRoom == null) {
          this.alertVisibility = true;
          this.backendError = false;
          this.missingArguments = true;
        } else {
          try {
            this.alertVisibility = false;
            this.backendError = false;
            this.missingArguments = false;
            const response = await axios.post(`${API_HOST}/api/windows`,{name:this.windowName,roomId:Number(this.selectedRoom)});
            this.$emit("new-window", response.data);
          } catch (error) {
            console.log(error);
            this.alertVisibility = true;
            this.backendError = true;
            this.missingArguments = false;
          }
          this.windowName = '';
          this.selectedRoom = null;
        }
      },
    },
  };
</script>

<style lang="scss">
.space-between-elements {
  margin-top: 15px;
}
</style>