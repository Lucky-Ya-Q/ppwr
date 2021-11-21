import request from '@/utils/request'

// 查询农药基本信息列表
export function listInfo(query) {
  return request({
    url: '/test/info/list',
    method: 'get',
    params: query
  })
}

// 查询农药基本信息详细
export function getInfo(id) {
  return request({
    url: '/test/info/' + id,
    method: 'get'
  })
}

// 新增农药基本信息
export function addInfo(data) {
  return request({
    url: '/test/info',
    method: 'post',
    data: data
  })
}

// 修改农药基本信息
export function updateInfo(data) {
  return request({
    url: '/test/info',
    method: 'put',
    data: data
  })
}

// 删除农药基本信息
export function delInfo(id) {
  return request({
    url: '/test/info/' + id,
    method: 'delete'
  })
}

// 导出农药基本信息
export function exportInfo(query) {
  return request({
    url: '/test/info/export',
    method: 'get',
    params: query
  })
}