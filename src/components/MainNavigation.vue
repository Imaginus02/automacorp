<template>
  <ul class="nav nav-tabs">
    <li class="nav-item" @click="setActiveTab('windows')">
      <a class="nav-link" :class="{ 'active': activeTab === 'windows' }" aria-current="page" href="#">Windows</a>
    </li>
    <li class="nav-item" @click="setActiveTab('rooms')">
      <a class="nav-link" :class="{ 'active': activeTab === 'rooms' }" href="#" tabindex="-1" aria-disabled="true">Rooms</a>
    </li>
    <li class="nav-item" @click="setActiveTab('buildings')">
      <a class="nav-link" :class="{ 'active': activeTab === 'buildings' }" href="#" tabindex="-1" aria-disabled="true">Buildings</a>
    </li>
  </ul>
</template>


<script>
export default {
  name: 'MainNavigation',
  emits: ["windows", "rooms", "buildings"],
  data() {
    return {
      activeTab: "windows"
    }
  },
  methods: {
    setActiveTab(string) {
      this.activeTab = string
      this.$emit(this.activeTab)
      console.log("Changing active tab to : " + this.activeTab);
    }
  }
}
</script>
