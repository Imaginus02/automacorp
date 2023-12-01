  <template>
  <div id="app">
    <header>
      <div class="title">{{title}}</div>
    </header>

    <section class="main-content w-50 mx-auto">
      <main-navigation @windows="show('windows')" @rooms="show('rooms')" @buildings="show('buildings')"></main-navigation>
      <windows-list v-if="selected === 'windows'"></windows-list>
      <rooms-list v-if="selected === 'rooms'"></rooms-list>
      <building-list v-if="selected === 'buildings'"></building-list>
    </section>
  </div>
</template>

<script>
import MainNavigation from './components/MainNavigation.vue';
import WindowsList from './components/window/WindowsList.vue';
import RoomsList from './components/room/RoomsList.vue';
import BuildingList from "./components/building/BuildingList.vue";

export default {
  name: 'App',
  components: {
    BuildingList,
    MainNavigation,
    WindowsList,
    RoomsList
  },
  data: function() {
    return {
      title: 'Automacorp',
      selected: 'windows'
    }
  },
  methods: {
    show(string) {
      this.selected = string;
    }
  }
}
</script>

<style lang="scss" scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;

  .title {
    text-align: center;
  }
}

</style>
