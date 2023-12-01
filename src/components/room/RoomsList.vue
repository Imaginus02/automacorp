<template>
    <div class="rooms-list pt-3">
      <RoomListItem v-for="room in rooms" :room="room" :key="room.id"></RoomListItem>
    </div>
</template>
  
  
<script>
import axios from 'axios';
import { API_HOST } from '../../config';
import RoomListItem from './RoomListItem.vue'

export default {
    components: {
      RoomListItem,

    },
    name: 'RoomsList',
    data: function () {
        return {
            /* Initialize rooms with an empty array, while waiting for actual data to be retrieved from the API */
            rooms: []
        }
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
    }
}
</script>
  

<style lang="scss">
.open-status {
  .icon {
    position: relative;

  }

  &.open {
    color: #198754;
    .icon {
      font-size: 12px;
      top: -3px;
    }

  }

  &.closed {
    color: #dc3545;

  }
}

</style>