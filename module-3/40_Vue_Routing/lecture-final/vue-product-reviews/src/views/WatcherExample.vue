<template>
<div>
  <h1>Watcher Example</h1>
  <input type="text" v-model="inputValue" />
  <div>Old Value: {{ oldValue }}</div>
  <div>New Value: {{ newValue }}</div>
</div>
</template>

<script>
export default {
    data() {
        return {
            inputValue: '',
            oldValue: '',
            newValue: ''
        }
    },
    watch: {
        inputValue: function (newValue, oldValue) {
            this.oldValue = oldValue;
            this.newValue = newValue;
        }
    }

}
</script>

<style>

</style>