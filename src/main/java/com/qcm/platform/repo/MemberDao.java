package com.qcm.platform.repo;

import java.util.List;

import com.qcm.platform.entities.Member;

public interface MemberDao
{
    public Member findById(Long id);

    public Member findByEmail(String email);

    public List<Member> findAllOrderedByName();

    public void register(Member member);
}
