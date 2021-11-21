import request from '@/utils/request'

// 查询入库记录列表
export function listRecords(query) {
  return request({
    url: '/test/records/list',
    method: 'get',
    params: query
  })
}

// 查询入库记录详细
export function getRecords(id) {
  return request({
    url: '/test/records/' + id,
    method: 'get'
  })
}

// 新增入库记录
export function addRecords(data) {
  return request({
    url: '/test/records',
    method: 'post',
    data: data
  })
}

// 修改入库记录
export function updateRecords(data) {
  return request({
    url: '/test/records',
    method: 'put',
    data: data
  })
}

// 删除入库记录
export function delRecords(id) {
  return request({
    url: '/test/records/' + id,
    method: 'delete'
  })
}

// 导出入库记录
export function exportRecords(query) {
  return request({
    url: '/test/records/export',
    method: 'get',
    params: query
  })
}