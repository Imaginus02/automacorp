<template>
  <div class="buildings-list pt-3">
    <building-list-item v-for="building in buildings" :building="building" :key="building.id"></building-list-item>
  </div>
</template>

<script>
import axios from 'axios';
import {API_HOST} from "../../config";
import BuildingListItem from "./BuildingListItem.vue";

export default {
  components: {
    BuildingListItem
  },
  name: "BuildingList",
  data: function() {
    return {
      buildings: []
    }
  },
  created: async function () {
    let response = await axios.get(`${API_HOST}/api/building`,{
      headers: {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
        'Access-Control-Allow-Credentials': 'true'
      }
    });
    this.buildings = response.data;
  },
  methods : {}
}

</script>